import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Producciones } from './producciones';

describe('Producciones', () => {
  let component: Producciones;
  let fixture: ComponentFixture<Producciones>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Producciones],
    }).compileComponents();

    fixture = TestBed.createComponent(Producciones);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
