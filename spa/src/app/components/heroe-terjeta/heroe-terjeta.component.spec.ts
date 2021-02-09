import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeroeTerjetaComponent } from './heroe-terjeta.component';

describe('HeroeTerjetaComponent', () => {
  let component: HeroeTerjetaComponent;
  let fixture: ComponentFixture<HeroeTerjetaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeroeTerjetaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeroeTerjetaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
